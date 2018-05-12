<div class="container-fluid">
<div class="row content-ops">
<div class="col-xs-6">
 <h4>{{value.type}}</h4>
</div>
<div class="col-xs-6">
<h4 style="text-align:right">
 <i class="fa fa-eye" aria-hidden="true"  data-toggle="collapse" title="preview" v-bind:data-target="'#demo'+index"></i>
 <i title="delete" class="fa fa-trash-o" @click="deleteItem(index)"></i>
</h4>
</div>
</div>
</div>
