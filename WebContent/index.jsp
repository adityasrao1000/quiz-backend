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
  <br>
  <div class="row">
    <div class="col-xs-6">
      <p>Tutorial</p>
      <select class="form-control input-sm" v-bind:value="tutorial" @input="updatefile($event)">
	    <option v-for="val in tutorials">{{val}}</option>
	  </select>
    </div>
    <div class="col-xs-6">
      <p>Section</p>
      <select class="form-control input-sm" v-bind:value="section"  @input="updateJsonObject($event)">
	    <option v-for="val in sections">{{val}}</option>
	  </select>
    </div>
  </div>
  <br> 
  <jsp:include page="add-content.jsp" />
  <div v-if="items.length" v-for="(value, index) in items">
  <div class="code" v-if="value.type==='code'">
    <div class="container-fluid">
	<div class="row content-ops">
	<div class="col-xs-6">
	 <h4 style="margin-top: 10px;">{{value.type}}</h4>
	</div>
	<div class="col-xs-6">
	<h4 style="text-align:right; display:flex">
	<select class="form-control input-sm" v-bind:value="value.language" @input="updateLanguage($event, index)">
    <option>javascript</option>
    <option>css</option>
    <option>clike</option>
    </select>
	 <i style="margin-top:5px; margin-left:12px" class="fa fa-eye" aria-hidden="true"  data-toggle="collapse" title="preview" v-bind:data-target="'#demo'+index"></i>
	 <i style="margin-top:7px" title="delete" class="fa fa-trash-o" @click="deleteItem(index)"></i>
	</h4>
	</div>
	</div>
	</div>
    <textarea class="form-control" rows="6" style="resize: vertical;" v-bind:value="value.item" @input="insert($event, index)"></textarea>
    <div v-bind:id="'demo'+index" class="collapse">
    <pre class="language-css" id="pre">{{value.item}}</pre>
    </div>
	<br>
	<jsp:include page="add-content.jsp" />
  </div>
  <div class="paragraph" v-if="value.type==='paragraph'">
    <jsp:include page="content-options.jsp" />
    <textarea class="form-control" rows="6" style="resize: vertical;" v-bind:value="value.item" class="paragraph"  @input="insert($event, index)"></textarea>
    <div v-bind:id="'demo'+index" class="collapse">
    <p style="background-color: #f5f5f5; border: 1px solid #ccc;" class="language-css" v-html="value.item"></p>
    </div>
    <br>
	<jsp:include page="add-content.jsp" />
  </div>
  <div class="title" v-if="value.type==='title'">
    <jsp:include page="content-options.jsp" />
    <input class="form-control" rows="6" v-bind:value="value.item" class="paragraph"  @input="insert($event, index)">
    <div v-bind:id="'demo'+index" class="collapse">
    <h4 style="background-color: #f5f5f5; border: 1px solid #ccc; margin-top:0; padding: 6px 1px;" class="language-css" id="pre">{{value.item}}</h4>
    </div>
	<br>
	<jsp:include page="add-content.jsp" />
  </div>
  <div class="title" v-if="value.type==='image-link'">
    <jsp:include page="content-options.jsp" />
    <input class="form-control" rows="6" v-bind:value="value.item" class="paragraph"  @input="insert($event, index)">
    <div v-bind:id="'demo'+index" class="collapse">
    <ul><li>{{value.item}}</li></ul>
    </div>
	<br>
	<jsp:include page="add-content.jsp" />
  </div>
  <div class="title" v-if="value.type==='bullet'">
    <div class="container-fluid">
	<div class="row content-ops">
	<div class="col-xs-6">
	 <h4>{{value.type}}</h4>
	</div>
	<div class="col-xs-6">
	<h4 style="text-align:right;">
	 <i class="fa fa-plus" @click="addSubBulletItem(index)" style="margin-right:12px;"></i>
	 <i class="fa fa-eye" aria-hidden="true"  data-toggle="collapse" title="preview" v-bind:data-target="'#demo'+index"></i>
	 <i class="fa fa-trash-o" @click="deleteItem(index)"></i>
	</h4>
	</div>
	</div>
	</div>
    <div v-for="(subvalue,subindex) in value.item">
    <input class="form-control" rows="6" v-bind:value="subvalue" class="paragraph"  @input="insertbulletValue($event, index, subindex)">
    </div>
    <div v-bind:id="'demo'+index" class="collapse">
    <ul>
      <li v-for="val in value.item">{{val}}</li>
    </ul>
    </div>
	<br>
	<jsp:include page="add-content.jsp" />
  </div>
  </div>
  <button @click="send" v-if="items.length>0" style="display:block;margin:auto;" type="button" class="btn btn-info">
  Commit changes
  </button>
  <br><br>
</div>
<div class="col-sm-2">
</div>
</div>
</div>
<script src="index.js"></script>
</body>
</html>