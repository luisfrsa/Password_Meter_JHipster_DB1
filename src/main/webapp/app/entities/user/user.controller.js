(function() {
    'use strict';

    angular
        .module('myJhipsterApp')
        .controller('UserController', UserController);

    UserController.$inject = ['User'];

    function UserController(User) {

        var vm = this;

        vm.users = [];

        loadAll();

        function loadAll() {
            User.query(function(result) {
                vm.users = result;
                vm.searchQuery = null;
            });
        }
    }
})();
