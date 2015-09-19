define(["application-configuration", "test2"], function(app, test2){

	console.dir(app);
	console.dir(test2);
	app.register.Controller("test", function($scope, test2){
		$scope.testa = test2.say();
	})
})