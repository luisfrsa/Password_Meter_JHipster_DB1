(function() {
    'use strict';
    angular
        .module('myJhipsterApp')
        .factory('User', User);

    User.$inject = ['$resource'];

    function User ($resource) {
        var resourceUrl =  'api/users/:id';

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
