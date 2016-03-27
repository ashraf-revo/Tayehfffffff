'use strict';

angular.module('revolovexApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
