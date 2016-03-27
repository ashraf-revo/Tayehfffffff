'use strict';

angular.module('revolovexApp')
    .controller('YourImageController', function ($http, $rootScope, $scope, $state, Auth) {
        $http.get("/api/images").success(function (imageExist) {
            $scope.imageExist = imageExist;
        });
    });
