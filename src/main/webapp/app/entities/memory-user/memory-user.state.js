(function() {
    'use strict';

    angular
        .module('myJhipsterApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('memory-user', {
            parent: 'entity',
            url: '/memory-user',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Memory_users'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/memory-user/memory-users.html',
                    controller: 'Memory_userController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('memory-user-detail', {
            parent: 'memory-user',
            url: '/memory-user/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Memory_user'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/memory-user/memory-user-detail.html',
                    controller: 'Memory_userDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'Memory_user', function($stateParams, Memory_user) {
                    return Memory_user.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'memory-user',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('memory-user-detail.edit', {
            parent: 'memory-user-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/memory-user/memory-user-dialog.html',
                    controller: 'Memory_userDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Memory_user', function(Memory_user) {
                            return Memory_user.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('memory-user.new', {
            parent: 'memory-user',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/memory-user/memory-user-dialog.html',
                    controller: 'Memory_userDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                name: null,
                                score: null,
                                num_cards: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('memory-user', null, { reload: 'memory-user' });
                }, function() {
                    $state.go('memory-user');
                });
            }]
        })
        .state('memory-user.edit', {
            parent: 'memory-user',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/memory-user/memory-user-dialog.html',
                    controller: 'Memory_userDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Memory_user', function(Memory_user) {
                            return Memory_user.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('memory-user', null, { reload: 'memory-user' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('memory-user.delete', {
            parent: 'memory-user',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/memory-user/memory-user-delete-dialog.html',
                    controller: 'Memory_userDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Memory_user', function(Memory_user) {
                            return Memory_user.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('memory-user', null, { reload: 'memory-user' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
