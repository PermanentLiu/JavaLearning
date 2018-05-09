var mysql  = require('mysql');  
var http = require('http');
var url = require('url');
var util = require('util');
 
var connection = mysql.createConnection({     
	host     : '111.230.56.68',       
	  user     : '1',              
	  password : 'Liu101517',       
	  port: '3306',                   
	  database: '1', 
}); 

var colID = "score"

var desc = function(x, y){
	return (x[colID] < y[colID]) ? 1 : -1
}

connection.connect();
 

http.createServer(function(req, res){
	
	res.writeHead(200, {'Content-Type': 'application/json'});
 
	var  sql = 'SELECT * FROM user';
	//查
 
	
	connection.query(sql,function (err, result) {
		if(err){
			console.log('[SELECT ERROR] - ',err.message);
			return;
		}
		//console.log(result);
		//res.json({result});
		
		result.sort(desc);
		
		res.end(JSON.stringify(result));
		console.log(result);
		

	});
	   

}).listen(11112);
console.log("start search!");

http.createServer(function(req, res){
    res.writeHead(200, {'Content-Type': 'text/plain'});
 
    // 解析 url 参数
    var params = url.parse(req.url, true).query;
    res.write("用户昵称：" + params.name);
    res.end();
	
	
 
	var  addSql = 'INSERT INTO user(name,score) VALUES(?,0)';
	var  addSqlParams = [params.name];
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
console.log("start insert!");


http.createServer(function(req, res){
	res.writeHead(200, {'Content-Type': 'text/plain'});
  
	 // 解析 url 参数
    var params = url.parse(req.url, true).query;
    res.write("name：" + params.name);
	res.write("\n");
	res.write("score: " + params.score); 
    res.end();

	var modSql = 'UPDATE user SET score = ? WHERE name = ?';
	var modSqlParams = [params.score, params.name];
	
	
	//改
	connection.query(modSql,modSqlParams,function (err, result) {
		
	   if(err){
			 console.log('[UPDATE ERROR] - ',err.message);
			 return;
	   }        
	  console.log('--------------------------UPDATE----------------------------');
	  console.log('UPDATE affectedRows',result.affectedRows);
	  console.log('-----------------------------------------------------------------\n\n');
	  return;
	});
  
}).listen(11113);
console.log("start modify!");

http.createServer(function(req, res){
	res.writeHead(200, {'Content-Type': 'text/plain'});
  
	 // 解析 url 参数
    var params = url.parse(req.url, true).query;
    res.write("name：" + params.name);
    res.end();
	
	var delSql = 'DELETE FROM user WHERE name = ?';
	var delSqlParams = [params.name];
	//改
	connection.query(delSql,delSqlParams,function (err, result) {
	   if(err){
			 console.log('[DELETE ERROR] - ',err.message);
			 return;
	   }        
	  console.log('--------------------------DELETE----------------------------');
	  console.log('DELETE affectedRows',result.affectedRows);
	  console.log('-----------------------------------------------------------------\n\n');
	});
  
}).listen(11114);

console.log("start delete!");

http.createServer(function(req, res){
	res.writeHead(200, {'Content-Type': 'text/plain'});
	
	// 解析 url 参数
    var params = url.parse(req.url, true).query;
    res.write("name：" + params.name);
    res.end();
	
	var  sql = 'SELECT * FROM user';
	//查
 
	
	connection.query(sql,function (err, result) {
		if(err){
			console.log('[SELECT ERROR] - ',err.message);
			return;
		}
		//console.log(result);
		
		////////////////////////////////////////////////////
		var myobj = eval(result);
		
		for (var i = 0; i < myobj.length; i++){
			if (myobj[i].name == params.name){
				console.log("score:" + myobj[i].score);
				console.log("   NO."+ i);
				var arrays;
				arrays[0] = i;
				arrays[1] = myobj[i].score;
				return arrays;
			}
		}
		

	});
	
	
	
	
}).listen(11110);
console.log("start search0");


