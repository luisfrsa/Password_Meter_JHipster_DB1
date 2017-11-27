(function () {
    'use strict';

    angular
            .module('myJhipsterApp')
            .controller('MeterController', MeterController);


    MeterController.$inject = ['Meter', '$resource'];

    function MeterController(Meter) {
        var vm = this;

        vm.score = 0;
        vm.strength = 'Muito pequena';
        vm.meter_additions = meter_additions;
        vm.meter_deductions = meter_deductions;

        vm.changePass = changePass;
        vm.getScoreColorAndText = getScoreColorAndText;
        function changePass($resource) {

            Meter.calc({'password': vm.password}, function (result) {
                var index = 0;
                vm.meter_additions.map(function (add) {
                    add.count = result[index][1];
                    add.bonus = result[index][2];
                    index++;
                    return add;
                });
                vm.meter_deductions.map(function (ded) {
                    ded.count = result[index][1];
                    ded.bonus = result[index][2];
                    index++;
                    return ded;
                });
                vm.score = result[16][2];
                vm.getScoreColorAndText();
            });
        }
        function getScoreColorAndText() {
            if (vm.score == 0) {
                vm.strength_color = {'background': '#ff0000'};
                vm.strength = 'Muito curta';
            } else if (vm.score < 20) {
                vm.strength_color = {'background': '#ff6e00'};
                vm.strength = 'Muito fraca';
            } else if (vm.score < 40) {
                vm.strength_color = {'background': '#ffd400'};
                vm.strength = 'Fraca';
            } else if (vm.score < 60) {
                vm.strength_color = {'background': '#c5e802'};
                vm.strength = 'Satisfatória';
            } else if (vm.score < 80) {
                vm.strength_color = {'background': '#2ed800'};
                vm.strength = 'Bom';
            } else {
                vm.strength_color = {'background': '#22aa06'};
                vm.strength = 'Muito bom';
            }
        }
    }
})();
