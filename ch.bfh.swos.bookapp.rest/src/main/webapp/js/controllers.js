'use strict';

var controllers = angular.module('controllers', ['services']);

controllers.controller('AuthorController', ['$scope', 'Author', function($scope, Author) {
    $scope.currentAuthor = new Author();
    $scope.authors = Author.query();
    $scope.showId = false;

    $scope.cancel = function () {
        $scope.currentAuthor = new Author();
    };

    $scope.save = function () {
        var isNew = $scope.currentAuthor.id == null;
        if (isNew) {
            $scope.currentAuthor = Author.save($scope.currentAuthor);
            $scope.authors.push($scope.currentAuthor);
        } else {
            $scope.currentAuthor = Author.update($scope.currentAuthor);
        }
        $scope.cancel();
    };

    $scope.edit = function (author) {
    	$scope.currentAuthor = author;
    };

    $scope.remove = function (index, id) {
		$scope.authors.splice(index, 1);
		Author.remove({authorId:id});
    };
}]);