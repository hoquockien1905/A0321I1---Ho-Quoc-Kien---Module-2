function add() {
    let numb1 = parseFloat(document.getElementById("numb1").value);
    let numb2 = parseFloat(document.getElementById("numb2").value);
    let result = numb1 + numb2;

    document.getElementById("result").innerHTML = "Result Addition = " + result;
};
function subtraction() {
    let numb1 = parseFloat(document.getElementById("numb1").value);
    let numb2 = parseFloat(document.getElementById("numb2").value);
    let result = numb1 - numb2;

    document.getElementById("result").innerHTML = "Result Subtraction = " + result;
};
function multiplication() {
    let numb1 = parseFloat(document.getElementById("numb1").value);
    let numb2 = parseFloat(document.getElementById("numb2").value);
    let result = numb1 * numb2;

    document.getElementById("result").innerHTML = "Result Multiplication = " + result;
};
function division() {
    let numb1 = parseFloat(document.getElementById("numb1").value);
    let numb2 = parseFloat(document.getElementById("numb2").value);
    let result = numb1 / numb2;

    document.getElementById("result").innerHTML = "Result Division = " + result;
};