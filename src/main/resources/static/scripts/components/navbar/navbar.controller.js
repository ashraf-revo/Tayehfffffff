'use strict';

angular.module('revolovexApp')
    .controller('NavbarController', function ($scope, $location, $state, Auth, Principal) {
        Principal.identity().then(function(account) {
            $scope.account = account;
            $scope.isAuthenticated = Principal.isAuthenticated;
        });
        $scope.logout = function () {
            Auth.logout();
            $state.go('home');
        };
    });
