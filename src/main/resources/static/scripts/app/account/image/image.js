'use strict';

angular.module('revolovexApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('image', {
                parent: 'account',
                url: '/image/:id',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'image'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/account/image/image.html',
                        controller: 'ImageController'
                    }
                }
            });
    });
