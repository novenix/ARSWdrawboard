
function setup() {
    createCanvas(1000, 700);
}


function draw() {
    if (mouseIsPressed === true) {
        var color = axios.get('/sessioncolor').then( color => {
            fill(color.data.r, color.data.g ,color.data.b );
            ellipse(mouseX, mouseY, 20, 20);
            var point = [mouseX, mouseY, color.data.r, color.data.g ,color.data.b ];

        });
    }
    if (mouseIsPressed === false) {
        fill(255,255,255);
    }
}

function refresh(){
    var points = axios.get('/point').then(points => {
        clear();
        if (points.data != null) {
            for (var i = 0; i < points.data.length; i++) {
                fill(points.data[i][2], points.data[i][3], points.data[i][4]);
                ellipse(points.data[i][0], points.data[i][1], 20, 20);
            }
        }
    });
}
setInterval(refresh, 1000);

function restart() {
    clear();
    axios.post('/restart');
}

function registro() {
    var x = document.getElementById("inputText").value;
    axios.get('/setname?name=' + x);
}