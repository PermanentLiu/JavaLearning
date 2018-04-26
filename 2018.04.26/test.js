var http = require('http');
var url = require('url');
var util = require('util');
var mysql  = require('mysql');  

var connection = mysql.createConnection({     
  host     : '111.230.56.68',       
  user     : '1',              
  password : 'Liu101517',       
  port: '3306',                   
  database: '1', 
}); 

connection.connect();
 
http.createServer(function(req, res){
    res.writeHead(200, {'Content-Type': 'text/plain'});
 
    // 解析 url 参数
    var params = url.parse(req.url, true).query;
    res.write("网站名：" + params.name);
    res.write("\n");
    res.write("网站 URL：" + params.url);
    res.end();
	
	
 
	var  addSql = 'INSERT INTO websites(Id,name,url,alexa,country) VALUES(0,?,?,?,?)';
	var  addSqlParams = [params.name, params.url,'23453', 'CN'];
	//增
	connection.query(addSql,addSqlParams,function (err, result) {
			if(err){
			 console.log('[INSERT ERROR] - ',err.message);
			 return;
			}        
	 
		   console.log('--------------------------INSERT----------------------------');
		   //console.log('INSERT ID:',result.insertId);        
		   console.log('INSERT ID:',result);        
		   console.log('-----------------------------------------------------------------\n\n');  
	});
	 
	
 
}).listen(11111);



 

 
