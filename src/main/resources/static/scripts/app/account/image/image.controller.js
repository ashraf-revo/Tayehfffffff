'use strict';

angular.module('revolovexApp')
    .controller('ImageController', function ($rootScope, $scope, $state, $http) {
        $http.post('/api/search', {"id": $state.params.id})
            .success(function (child) {
                $scope.child = child;
            });
    });
