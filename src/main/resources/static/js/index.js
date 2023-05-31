$(document).ready(function() {
    $('#dropdown').on('change', function () {
        if (['AM', 'AU', 'AZ', 'BY', 'GB', 'BG', 'HR', 'CZ', 'EE', 'FR', 'DE', 'GR', 'HU', 'IE', 'IT', 'KZ', 'KO', 'KG', 'LT', 'MD', 'ME', 'NO', 'PL', 'RO', 'RU', 'SK', 'SI', 'SE', 'CH', 'TR', 'UA', 'UZ'].indexOf(this.value) > -1) {
            $("#image").classList.remove('hidden');
        } else {
            $("#image").classList.add('hidden');
        }
    }).change();
});