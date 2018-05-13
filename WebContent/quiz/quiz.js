
var vm = new Vue({
	  el: '#quiz',
	  data: {
		  quizzes: []
	  },
	  methods: {
		  
	  },
	  mounted: function(){
		  let self = this;
		  axios({
			  method: 'get',
			  url: 'directories'
			})
			.then(function (response) {
			    if(response.data.length > 0){
			     response.data.forEach(result => vm.tutorials.push(result) );
			     self.updatetutorial();
			    }
		    })
		    .catch(function (error) {
		        console.log(error);
		    });
	  }
});