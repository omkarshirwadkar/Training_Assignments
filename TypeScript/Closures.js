
// How to define a closure
var inc = function incr(){
    var a = 0
    var plus = function(){
        a++;
        console.log(a);
    }
    return plus;
}();

inc();
inc();
inc();
inc();