(function() {
    'use strict';
    angular
        .module('myJhipsterApp')
        .factory('Memory_user', Memory_user);

    Memory_user.$inject = ['$resource'];

    function Memory_user ($resource) {
        var resourceUrl =  'api/memory-users/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
