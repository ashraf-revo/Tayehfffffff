'use strict';

angular.module('revolovexApp')
    .controller('MainController', function ($scope, $http, dialogs, Principal) {
        Principal.identity().then(function (account) {
            $scope.account = account;
            $scope.isAuthenticated = Principal.isAuthenticated;
        });
        $scope.searchcriteria = {};
        $scope.searchcriteria.isnewData = false;
        $scope.searchcriteria.page = 0;
        $scope.child = [];
        $scope.load = function () {
            $http.post('/api/searchcriteria', $scope.searchcriteria)
                .success(function (child) {

                    if (!$scope.searchcriteria.isnewData)
                        for (var i = 0; i < child.length; i++)
                            $scope.child.push(child[i]);
                    else
                        $scope.child = child;
                    $scope.searchcriteria.page++;
                    $scope.searchcriteria.isnewData = false;
                    console.log($scope.searchcriteria)
                });
        };
        $scope.init = function () {
        };
        $scope.search = function () {
            $scope.searchcriteria = {};
            $scope.searchcriteria.isnewData = true;
            $scope.searchcriteria.page = 0;
            if ($scope.bname && angular.isDefined($scope.form.name)) {
                $scope.searchcriteria.name = $scope.form.name
            }
            if ($scope.bage && angular.isDefined($scope.form.age1) && angular.isDefined($scope.form.age2)) {
                $scope.searchcriteria.age1 = $scope.form.age1.toString();
                $scope.searchcriteria.age2 = $scope.form.age2.toString();
            }
            if ($scope.bgender && angular.isDefined($scope.form.gender)) {
                $scope.searchcriteria.gender = $scope.form.gender;
            }
            if ($scope.bdate && angular.isDefined($scope.form.date1) && angular.isDefined($scope.form.date2)) {
                $scope.searchcriteria.date1 = $scope.form.date1;
                $scope.searchcriteria.date2 = $scope.form.date2;
            }
            if ($scope.bstate && angular.isDefined($scope.form.state)) {
                $scope.searchcriteria.state = $scope.form.state;
            }
            $scope.load();
        };
        $scope.launch = function () {

            var dlg = dialogs.create('scripts/components/dialogs/updateps.html', 'updatePs', {}, {size: 'lg'});
            dlg.result.then(function () {
                $scope.search();
            });

        };
        $scope.load();

    }).controller('updatePs', function ($scope, $uibModalInstance, data, $http, $base64) {
        $scope.fileChanged = function (e) {

            var files = e.target.files;

            var fileReader = new FileReader();
            fileReader.readAsDataURL(files[0]);

            fileReader.onload = function (e) {
                $scope.imgSrc = this.result;
                $scope.$apply();
            };

        };

        $scope.clear = function () {
            $scope.imageCropStep = 1;
            delete $scope.imgSrc;
            delete $scope.result;
            delete $scope.resultBlob;
        };
        $scope.cancel = function () {
            $uibModalInstance.dismiss();
        };
        $scope.save = function () {

            $scope.dform.file = $scope.result.substring($scope.result.indexOf(";base64,") + 8);

            $http.post("/api/uplode", $scope.dform)
                .success(function () {
                    $uibModalInstance.close();
                });

        };
    });