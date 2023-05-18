package com.example.doanbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "order_material")
public class OrderMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "order_code")
    private String orderCode;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "status")
    private boolean isStatus;
    @Column(name = "ngay_order")
    private LocalDateTime ngayOrder;
    @Column(name = "ngay_phe_duyet")
    private LocalDateTime ngayPheDuyet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petitioner_id")
    private User petitioner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approver_id")
    private User approver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accessory_id")
    private LinhKien accessory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id")
    private VatLieu material;


    @PrePersist
    public void prePersist() {
        this.isStatus = false;
        this.ngayOrder = LocalDateTime.now();
    }

    @PostUpdate
    public void postUpdate() {
        this.ngayPheDuyet = LocalDateTime.now();
    }
}
