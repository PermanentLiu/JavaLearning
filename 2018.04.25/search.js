var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : '111.230.56.68',
  user     : '1',
  password : 'Liu101517',
  database : '1',
  port     : '3306'
});
 
connection.connect();
 
var  sql = 'SELECT * FROM websites';
//查
connection.query(sql,function (err, result) {
        if(err){
          console.log('[SELECT ERROR] - ',err.message);
          return;
        }
 
       console.log('--------------------------SELECT----------------------------');
       console.log(result);
       console.log('------------------------------------------------------------\n\n');  
});
 
connection.end();