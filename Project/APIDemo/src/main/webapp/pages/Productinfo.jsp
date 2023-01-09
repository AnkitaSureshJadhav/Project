<html>
<head>
		<title> mypage</title>
		<style>
			table,td,th
			{
				border:1px solid red;
			}
			td,th
			{
				padding:10px;
				text-align:center;
				
			}
			table
			{
				margin:auto;
				
			}
	</style>
	
		<script>

					var xmlhttp;
														
					function getAllData()
					{
						
						xmlhttp=new XMLHttpRequest();
						xmlhttp.onload=display; // value of onload property is name of that function which should be called when response is loaded from server
					
						xmlhttp.open("get","productapi/allProducts");
						xmlhttp.send();
												
					}
					
					function display()
					{
							//alert("hello");

								
							var table=document.getElementById("table1");
							table.innerHTML=""; // clear existing rows from table

							var headingrow=document.createElement("tr");

							var pidheading=document.createElement("th");
							var nameheading=document.createElement("th");
							var priceheading=document.createElement("th");
							var imgheading=document.createElement("th");
							
							var pidvalue=document.createTextNode("product id");
							var namevalue=document.createTextNode("product name");
							var pricevalue=document.createTextNode("product price");
							var imgvalue=document.createTextNode("product image");
							
							pidheading.appendChild(pidvalue);
							nameheading.appendChild(namevalue);
							priceheading.appendChild(pricevalue);
							imgheading.appendChild(imgvalue);


							headingrow.appendChild(pidheading)
							headingrow.appendChild(nameheading)
							headingrow.appendChild(priceheading)
							headingrow.appendChild(imgheading)
							
							
							table.appendChild(headingrow);


							var data=xmlhttp.responseText;

							//alert(data);
							
							
							// data ==> [ {"rno":1,"marks":70} , {"rno":2,"marks":80} ]
									
							data=data.substring(1,data.length-1);
							
							//alert(data);

							
							/*
							String s="java";  //  [java] 
							s=s.concat("KiranAcademy");// s==>[java KiranAcademy]
							sop(s);
							*/

							// data ==> {"rno":1,"marks":70} , {"rno":2,"marks":80} , {"rno":3,"marks":70}
							
							var newstr="";  // {""rno":1,"marks":70}

							// creating new string where we will add character #, so that we can split strings
							// based on # .
														
							for(var i=0;i<data.length;i++)
							{
							//	alert(data[i]);
								var character=data[i];
								if(character==',' && data[i+1]=='{')
								{
									newstr=newstr+"#";
								}
								else
								{
									newstr=newstr+character;
								}
								
							}

						//	alert(newstr);

							// newstr ==> {"rno":1,"marks":70} # {"rno":2,"marks":80} # {"rno":3,"marks":70}
							
							var jsonstrings=newstr.split("#");



							
							for(var i=0;i<jsonstrings.length;i++)
							{

									var jsonrecord=jsonstrings[i];
									
				//					alert(jsonrecord);
																	
									var object=JSON.parse(jsonrecord);
									
									var row=document.createElement("tr");

									var pidtd=document.createElement("td");
									var nametd=document.createElement("td");
									var pricetd=document.createElement("td");
									var imagetd=document.createElement("td");
									
									var pidvalue=document.createTextNode(object.pid);
									var namevalue=document.createTextNode(object.name);
									var pricevalue=document.createTextNode(object.price);
									var productimage=document.createElement("img");
									productimage.src="/images/"+object.imagepath;
									
									productimage.width="40";
									productimage.height="40";
									
									//alert(productimage.src);
									
									pidtd.appendChild(pidvalue);
									nametd.appendChild(namevalue);
									pricetd.appendChild(pricevalue);
									imagetd.appendChild(productimage);
									
									row.appendChild(pidtd);
									row.appendChild(nametd);
									row.appendChild(pricetd);
									row.appendChild(imagetd);
									
									table.appendChild(row);
									
							}
							
					}
					


					function getData(button)
					{
						
						var pid=document.productform.pid.value;// reading product id typed by user
						
						xmlhttp=new XMLHttpRequest(); // XMLHttpRequest is predefined class

						buttonClicked=button.value;

						if(buttonClicked=="get")
						{
										
										xmlhttp.open("get","productapi/viewproduct/"+ pid);// send pid to API method
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

						// obj==>[pid=701 name=noodles price=300] javascript object	
								
						var name=obj.name;
						var price=obj.price;
						
						
				// when exception occurs , message variable value will be record not found and below 
				// condition will be satisfied
						
							document.productform.name.value=name;
							document.productform.price.value=price;
							var productImage=document.getElementById("i1");
							
							productImage.src="/images/"+obj.imagepath;
							productImage.width="40";
							productImage.height="40";
							
						
					}
											
			</script>
		
</head>

<body>


 ${username}

<%!
  String imageURL="";
%>

<%
	imageURL="/images/"+ request.getAttribute("imagepath");
%>
<br><br>
<img src=<%=imageURL %> height=100px width=100px>
<br><br>



<br><br>

<form align ="center" name ="productform">

             <h2> All Product Information</h2>

			<label for="pid"> <b> Product ID</b></label>
			<input type="text" name="pid" placeholder="Enter product id"><span id="errorMessage"> </span><br><br>
			<label for="name"> <b> Product Name</b></label>
			<input type="text" name="name" placeholder="Enter product name"><br><br>
			<label for="price"> <b> Product  Price</b></label>
			<input type="text" name="price" placeholder="Enter product price"><br><br>
			
			<img id="i1"><br><br><br><br>
									
			<input type="button" value="getall" onclick="getAllData()">
			<input type=button value=get onclick="getData(this)">

			<br><br><br>
						
			<table id="table1">
				
			</table>
			
</form>

<p id="p1">  </p>

</body>

</html>