(function() {
    'use strict';

    angular
        .module('myJhipsterApp')
        .controller('Memory_userDialogController', Memory_userDialogController);

    Memory_userDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Memory_user'];

    function Memory_userDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Memory_user) {
        var vm = this;

        vm.memory_user = entity;
        vm.clear = clear;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.memory_user.id !== null) {
                Memory_user.update(vm.memory_user, onSaveSuccess, onSaveError);
            } else {
                Memory_user.save(vm.memory_user, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('myJhipsterApp:memory_userUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
