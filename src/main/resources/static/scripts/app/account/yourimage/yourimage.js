'use strict';

angular.module('revolovexApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('yourimage', {
                parent: 'account',
                url: '/yourimage',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'yourimage'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/account/yourimage/yourimage.html',
                        controller: 'YourImageController'
                    }
                }
            });
    });
