<!DOCTYPE html>
<html>
<head>
<title>Create Tutorial</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="libraries.jsp" %> 
<link rel="stylesheet" href="index.css">
</head>
<body>
<div class="container-fluid" id="index">
<div class="row">
<div class="col-sm-1">
</div>
<div class="col-sm-9">
  <br><br>
  <div>  
  
    <jsp:include page="add-content.jsp" />
  </div>
  <div v-if="items.length" v-for="(value, index) in items">
  <div class="code" v-if="value.type==='code'">
    <div class="row">
    <h4 class="col-sm-6">Code:</h4>
    <h4 class="col-sm-6" style="text-align:right">
    <i class="fa fa-eye" aria-hidden="true"  data-toggle="collapse" v-bind:data-target="'#demo'+index"></i>
    <i data-toggle="tooltip" data-placement="top" title="delete" class="fa fa-trash-o" @click="deleteItem(index)"></i>
    </h4>
    </div>
    <textarea class="form-control" rows="6" style="resize: vertical;" v-bind:value="value.item" @input="insert($event, index)"></textarea>
    <div v-bind:id="'demo'+index" class="collapse">
    <pre class="language-css" id="pre">{{value.item}}</pre>
    </div>
	<br><br>
	<jsp:include page="add-content.jsp" />
  </div>
  <div class="paragraph" v-if="value.type==='paragraph'">
    <div class="row">
    <h4 class="col-sm-6">Paragraph:</h4>
    <h4 class="col-sm-6" style="text-align:right">
    <i class="fa fa-eye" aria-hidden="true"  data-toggle="collapse" v-bind:data-target="'#demo'+index"></i>
    <i data-toggle="tooltip" data-placement="top" title="delete" class="fa fa-trash-o" @click="deleteItem(index)"></i>
    </h4>
    </div>
    <textarea class="form-control" rows="6" style="resize: vertical;" v-bind:value="value.item" class="paragraph"  @input="insert($event, index)"></textarea>
    <div v-bind:id="'demo'+index" class="collapse">
    <p style="background-color: #f5f5f5; border: 1px solid #ccc;" class="language-css" id="pre">{{value.item}}</p>
    </div>
    <br><br>
	<jsp:include page="add-content.jsp" />
  </div>
  <div class="title" v-if="value.type==='title'">
    <div class="row">
    <h4 class="col-sm-6">title:</h4>
    <h4 class="col-sm-6" style="text-align:right">
    <i class="fa fa-eye" aria-hidden="true"  data-toggle="collapse" v-bind:data-target="'#demo'+index"></i>
    <i data-toggle="tooltip" data-placement="top" title="delete" class="fa fa-trash-o" @click="deleteItem(index)"></i>
    </h4>
    </div>
    <input class="form-control" rows="6" v-bind:value="value.item" class="paragraph"  @input="insert($event, index)">
    <div v-bind:id="'demo'+index" class="collapse">
    <h4 style="background-color: #f5f5f5; border: 1px solid #ccc; margin-top:0; padding: 6px 1px;" class="language-css" id="pre">{{value.item}}</h4>
    </div>
	<br><br>
	<jsp:include page="add-content.jsp" />
  </div>
  </div>
  <button @click="send" style="display:block;margin:auto;" type="button" class="btn btn-info">Commit changes</button>
  <br><br>
</div>
<div class="col-sm-2">
</div>
</div>
</div>
<script src="index.js"></script>
</body>
</html>