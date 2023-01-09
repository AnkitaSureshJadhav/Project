<html>
<head>
<style>
	
</style>

<script>

	var xmlhttp;
	var buttonClicked;
	var message;
	
	
	function sendData(button)
	{
		var cid=document.categoryform.cid.value;
		var name=document.categoryform.name.value;

		var javascriptobject={"cid":cid,"name":name};
		
		xmlhttp=new XMLHttpRequest(); // XMLHttpRequest is predefined class

		 buttonClicked=button.value;

		if(buttonClicked=="post")
		{	
				message="data is posted successfully";
				xmlhttp.open("post","categoryapi/saveCategory");
		}
		
		else
		{
			    message="data is updated successfully";
			
				xmlhttp.open("put","categoryapi/updateCategory");
		}
		
		xmlhttp.onload=displayResponse; 

		// when response is loaded from API , then call displayResponse  function .
		// DO NOT write displayResponse() . just write displayResponse.
		
		 var jsonstring=JSON.stringify(javascriptobject);

		xmlhttp.setRequestHeader('Content-type', 'application/json')
		
		xmlhttp.send(jsonstring);

		alert("Data is sent to API " + jsonstring);
		
	}

	function displayResponse()
	{
			alert(xmlhttp.responseText);

			document.getElementById("message").innerHTML=message;	
				
	}

	function getData(button)
	{
		
		var cid=document.categoryform.cid.value;// reading category id typed by user
		
		xmlhttp=new XMLHttpRequest(); // XMLHttpRequest is predefined class

		buttonClicked=button.value;

		if(buttonClicked=="get")
		{
						message="data is retrieved successfully";
						xmlhttp.open("get","categoryapi/getCategory/"+ cid);// send cid to API method
		}
		
		else
		{
			message="data is deleted successfully";
			xmlhttp.open("delete","categoryapi/deleteCategory/"+ cid);// send cid to API method
		}
			
		xmlhttp.onload=displayResponse2; 

		// when response is loaded from API , then call displayResponse2  function .
		// DO NOT write displayResponse2() . just write displayResponse2.
				
		xmlhttp.send();
							
	}

	function displayResponse2()
	{	
		
		var jsonstring=xmlhttp.responseText;
		var obj=JSON.parse(jsonstring); // parse() converts JSON String to JavaScript object

		// obj ==> {cid:1,name:"stationery"} if record is found
		// obj ==> {message:record not found} if record is NOT found
		
		var name=obj.name;
	    
// when exception occurs , message variable value will be record not found and below 
// condition will be satisfied

	    if(obj.message!=undefined) 
		{
	    	document.categoryform.name.value=""; 

			document.getElementById("message").innerHTML=obj.message;	
						
		}
	    else
		{
			document.categoryform.name.value=name;

			document.getElementById("message").innerHTML=message;	
		}
	}

	function getAllData()
	{
		
		xmlhttp=new XMLHttpRequest(); // XMLHttpRequest is predefined class

		xmlhttp.onload=displayResponse3;

		xmlhttp.open("get","categoryapi/getAllCategory");

		xmlhttp.send();	 
		
	}

	function displayResponse3()
	{
			alert(xmlhttp.responseText);

			//int[] a={};  java 
			
			var allJSONStrings=xmlhttp.responseText;// allJSONStrings is a array

			var p1=document.getElementById("p1");

			var data="";
		/*	
		for(var i=0;i<allJSONStrings.length;i++)
		{
			alert(allJSONStrings[i]);
			
			var obj=JSON.parse(allJSONStrings[i]); // parse() converts JSON String to JavaScript object
			data=data+obj+ "<br>";
		}
*/
		p1.innerHTML=allJSONStrings;
		
			

    }

	
	
</script>

</head>

<body>

<span id="message"></span>

<form name=categoryform align = "center" action ="categoryapi">

<h2> Category Information</h2>
<label for="cid"> <b>Category Id</b></label>
<input name=cid><br><br>
<label for="name"> <b>Category name</b></label>

<input name=name> <br><br>

<input type=button value=Save onclick="sendData(this)">
<input type=button value=search onclick="getData(this)">
<input type=button value=Update onclick="sendData(this)">
<input type=button value=Delete onclick="getData(this)">
<input type=button value=SearchAll onclick="getAllData()">

</form>


<p id="p1"> All Data </p> 

</body>

</html>