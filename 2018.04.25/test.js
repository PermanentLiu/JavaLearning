var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : '111.230.56.68',
  user     : '1',
  password : 'Liu101517',
  database : '1',
  port     : '3306'
});
 
connection.connect();
 
connection.query('SELECT 1 + 1 AS solution', function (error, results, fields) {
  if (error) throw error;
  console.log('The solution is: ', results[0].solution);
});