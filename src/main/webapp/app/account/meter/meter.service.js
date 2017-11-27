(function () {
    'use strict';
    angular
            .module('myJhipsterApp')
            .factory('Meter', Meter);

    Meter.$inject = ['$resource'];
    function Meter($resource) {
        var resourceUrl =  'api/meter';

        return $resource(resourceUrl, {}, {
            'calc': {
                method: 'POST',
                //isArray: true,
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            }
        });
        //return{            calc: function (password) {                var res = $resource('api/meter/' + encodeURI(password), {}, {                    calc: {method: 'GET',isArray: true},                });                return res.calc();            }        };
    }
})();


