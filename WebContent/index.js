
var vm = new Vue({
	  el: '#index',
	  data: {
	      items: []
	  },
	  methods: {
		  submit: function(){
			  let obj = JSON.stringify({code: text.value.trim()});
			  pre.innerHTML = JSON.parse(obj).code;
		  },
		  send: function(){
			  let items = this.items;
			  axios({
				  method: 'post',
				  url: 'tutorial/javascript',
				  data: items,
				  headers: { contentType: "application/json; charset=utf-8"}
				})
				.then(function (response) {
				    console.log(response);
			    })
			    .catch(function (error) {
			        console.log(error);
			    });
		  },
		  insert: function(event, index) {
			  this.items[index].item = event.target.value;
		  },
		  deleteItem: function(index){
			  this.items.splice(index, 1);
		  },
		  insertContent: function(pos, type){
			  if(type==='code'){
				  this.items.splice(pos,0,{"item":"","type":"code"});
			  }
			  if(type==='paragraph'){
				  this.items.splice(pos,0,{"item":"","type":"paragraph"});
			  }
			  if(type==='title'){
				  this.items.splice(pos,0,{"item":"","type":"title"});
			  }
			  if(type==='image-link'){
				  this.items.splice(pos,0,{"item":"","type":"image-link"});
			  }
		  },
		  imageFailed: function(event){
			  event.target.src="https://energywater.gr/wp-content/uploads/2017/12/noimage-9-1000x1000.png";
		  }
	  }
});