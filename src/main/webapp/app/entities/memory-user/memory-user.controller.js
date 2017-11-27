(function() {
    'use strict';

    angular
        .module('myJhipsterApp')
        .controller('Memory_userController', Memory_userController);

    Memory_userController.$inject = ['Memory_user'];

    function Memory_userController(Memory_user) {

        var vm = this;

        vm.memory_users = [];

        loadAll();

        function loadAll() {
            Memory_user.query(function(result) {
                vm.memory_users = result;
                vm.searchQuery = null;
            });
        }
    }
})();
