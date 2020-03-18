/**
 * This function is used to return the string repeated the number of times specified
 */
String.prototype.repeatify = function(number) {
    str = this;
    result = "";

    for (iterator = 0; iterator < number; iterator++) {
        result += str;
    }
    return result;
}
console.log('hello'.repeatify(3));