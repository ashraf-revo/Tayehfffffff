'use strict';

angular.module('revolovexApp')
    .controller('LoginController', function ($rootScope, $scope, $state,Auth) {
        $scope.user = {};
        $scope.errors = {};

        $scope.rememberMe = true;
        $scope.login = function () {
            Auth.login({
                username: $scope.username,
                password: $scope.password,
                rememberMe: $scope.rememberMe
            }).then(function () {
                $scope.authenticationError = false;
                if ($rootScope.previousStateName === 'register') {
                    $state.go('home');
                } else {
                    $rootScope.back();
                }
            }).catch(function () {
                $scope.authenticationError = true;
            });
        };
    });
