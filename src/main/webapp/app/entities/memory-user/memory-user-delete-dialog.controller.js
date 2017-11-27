(function() {
    'use strict';

    angular
        .module('myJhipsterApp')
        .controller('Memory_userDeleteController',Memory_userDeleteController);

    Memory_userDeleteController.$inject = ['$uibModalInstance', 'entity', 'Memory_user'];

    function Memory_userDeleteController($uibModalInstance, entity, Memory_user) {
        var vm = this;

        vm.memory_user = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Memory_user.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
