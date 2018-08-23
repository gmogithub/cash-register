const validator = {
    email: {
        method: 'isEmail',
        message: 'Email must be valid',
        validWhen: true,
    },
    firstname: {
        method: 'isEmpty',
        message: 'firstname is needed',
        validWhen: false,
    },
    lastname: {
        method: 'isEmpty',
        message: 'Lastname is needed',
        validWhen: false,
    },
    civility: {
        method: 'isEmpty',
        message: 'You need to choose the civility',
        validWhen: false,
    },
    phone: {
        method: 'isMobilePhone',
        args: ['fr-FR', 'en-US'],
        message: 'The phone you enter is not correct',
        validWhen: true,
    },
    country_code: {
        method: 'isEmpty',
        message: 'You need to choose a country',
        validWhen: false,
    },
    password: [
        {
            name: 'checkLengthPassword',
            method: str => str.length >= 8,
            message: 'The password must be 8 characters minimum',
            validWhen: true,
        },
        {
            name: 'checkUppercase',
            method: str => !!str.match(/[A-Z]/g),
            message: 'The password must contain one uppercase letter',
            validWhen: true,
        },
        {
            name: 'checkNumber',
            method: str => !!str.match(/[0-9]/g),
            message: 'The password must contain one number',
            validWhen: true,
        },
        {
            name: 'checkSpecialChar',
            method: str => !!str.match(/[^A-Za-z0-9]/g),
            message: 'The password must contain one special char',
            validWhen: true,
        },
    ],
};

export default validator;