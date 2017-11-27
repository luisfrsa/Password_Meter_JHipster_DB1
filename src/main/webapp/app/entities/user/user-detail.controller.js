(function() {
    'use strict';

    angular
        .module('myJhipsterApp')
        .controller('UserDetailController', UserDetailController);

    UserDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'User'];

    function UserDetailController($scope, $rootScope, $stateParams, previousState, entity, User) {
        var vm = this;

        vm.user = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('myJhipsterApp:userUpdate', function(event, result) {
            vm.user = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
