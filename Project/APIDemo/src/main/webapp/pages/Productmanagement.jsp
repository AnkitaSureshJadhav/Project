<html>
<head>
<style>
</style>
</head>


<body>
<span id="message">${message}</span>
	
<form  align ="center" name ="productform"  enctype="multipart/form-data">
			
			<h2> Product Information</h2>
			
			<label for="pid"> <b> Product ID</b></label>			
			<input type="text" name="pid" placeholder="Enter product id"><span id="errorMessage"> </span><br><br>
			<label for="name"> <b> Product Name</b></label>
			<input type="text" name="name" placeholder="Enter product name"><br><br>
			<label for="price"> <b> Product  Price</b></label>
			<input type="text" name="price" placeholder="Enter product price"><br><br>
			<label for="cid"> <b> Category ID</b></label>
			<input type="text" name="cid" placeholder="Enter category id"><br><br>
			<label>Select Photo	</label>
			<input type="file" name="images"><br><br>
			<input type=submit value=post formmethod=post formaction="saveProduct">

			<br><br><br>
						
			<table id="table1">
				
			</table>
			
</form>

<p id="p1"> </p>

</body>

</html>