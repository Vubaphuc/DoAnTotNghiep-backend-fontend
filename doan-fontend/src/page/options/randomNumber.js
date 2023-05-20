export const generateRandomNumber = () => {
    const min = 100000;
    const max = 999999;

    let num = Math.floor(Math.random() * (max - min + 1) + min);
    let code = num.toString().split('');
    let ans = [...new Set(code)];

}

export default generateRandomNumber;