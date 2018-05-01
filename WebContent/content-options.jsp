<div class="row">
  <h4 class="col-sm-6">{{value.type}}:</h4>
  <h4 class="col-sm-6" style="text-align:right">
  <i class="fa fa-eye" aria-hidden="true"  data-toggle="collapse" v-bind:data-target="'#demo'+index"></i>
  <i data-toggle="tooltip" data-placement="top" title="delete" class="fa fa-trash-o" @click="deleteItem(index)"></i>
  </h4>
</div>