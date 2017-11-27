(function() {
    'use strict';

    angular
        .module('myJhipsterApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('meter', {
            parent: 'account',
            url: '/meter',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'DB1 Password Meter'
            },
            views: {
                'content@': {
                    templateUrl: 'app/account/meter/meter.html',
                    controller: 'MeterController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
