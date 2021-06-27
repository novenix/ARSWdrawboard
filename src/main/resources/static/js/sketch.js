
function setup() {
    createCanvas(1000, 700);
}


function draw() {
    if (mouseIsPressed === true) {
        var color = axios.get('/getusercolor').then( color => {
            fill(color.data.r, color.data.g ,color.data.b );
            ellipse(mouseX, mouseY, 20, 20);
            var point = [mouseX, mouseY, color.data.r, color.data.g ,color.data.b ];
            axios.post('/draw', point);
        });
    }
    if (mouseIsPressed === false) {
        fill(255,255,255);
    }
}

function refresh(){
    var points = axios.get('/draw').then(points => {
        clear();
        if (points.data != null) {
            for (var i = 0; i < points.data.length; i++) {
                fill(points.data[i][2], points.data[i][3], points.data[i][4]);
                ellipse(points.data[i][0], points.data[i][1], 20, 20);
            }
        }
    });
}
setInterval(refresh, 500);

function limpiar() {
    clear();
    axios.post('/reset');
}

function guardar() {
    var x = document.getElementById("userName").value;
    axios.get('/setname?name=' + x);
}