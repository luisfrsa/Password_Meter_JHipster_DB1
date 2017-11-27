(function() {
    'use strict';

    angular
        .module('myJhipsterApp')
        .controller('Memory_userDetailController', Memory_userDetailController);

    Memory_userDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Memory_user'];

    function Memory_userDetailController($scope, $rootScope, $stateParams, previousState, entity, Memory_user) {
        var vm = this;

        vm.memory_user = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('myJhipsterApp:memory_userUpdate', function(event, result) {
            vm.memory_user = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
