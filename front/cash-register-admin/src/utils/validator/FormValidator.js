import Validator from 'validator';

class FormValidator {
    constructor() {
        // validations is an array of validation rules specific to a form
        //this.validators = validators;
        this.errors = {};
    }

    hasError(field, namedField = false) {
        if (this.errors[field] !== undefined) {
            if (namedField) {
                return this.errors[field].find(err => err.name === namedField) !== undefined;
            } else {
                return !this.errors[field].isValid;
            }
        } else {
            return false;
        }
    }

    isValid() {
        return !this._containsErrors(Object.values(this.errors));
    }

    getErrorMessage(field) {
        if (this.errors[field] !== undefined) {
            if (Array.isArray(this.errors[field])) {
                if (this.errors[field].length > 0) {
                    return this.errors[field][0].message;
                }
            } else {
                return this.errors[field].message;
            }
        }
    }

    validateField(field, value) {
        const rules = this.validators[field];
        if (!Array.isArray(rules)) {
            return this._validateSingleField(field, value);
        } else {
            return this._validateMultipleFields(field, value);
        }
    }

    validateForm(state) {
        for (const stateProperty in state) {
            this.validateField(stateProperty, state[stateProperty]);
        }
    }

    // PRIVATE METHODS
    _containsErrors(errors) {
        return !!errors.find((err) => {
            if (Array.isArray(err)) {
                return err.find((err) => {
                    return err.isValid === false;
                });
            } else {
                return err.isValid === false;
            }
        });
    }

    _validateSingleField(field, value) {
        const rule = this.validators[field];
        const validation_method = this._getMethodFromRule(rule, value);
        if (!(validation_method === rule.validWhen)) {
            this.errors[field] = {
                isValid: false,
                message: rule.message,
            };
        } else {
            this.errors[field] = {isValid: true, message: ''};
        }
    }

    _validateMultipleFields(field, value) {
        const rules = this.validators[field];
        if (this.errors[field] === undefined) {
            this.errors[field] = [];
        }
        for (const rule of rules) {
            const validation_method = this._getMethodFromRule(rule, value);
            if (!(validation_method === rule.validWhen)) {
                const isAlreadyAdded = this.errors[field].find(
                    (err) => err.message === rule.message);
                if (!isAlreadyAdded) {
                    this.errors[field].push({
                        name: rule.name,
                        isValid: false,
                        message: rule.message,
                    });
                }
            } else {
                this.errors[field] = this.errors[field].filter(
                    (err) => err.message !== rule.message);
            }
        }
    }

    _getMethodFromRule(rule, value) {
        if (typeof rule.method === 'string') {
            if (typeof rule.args !== 'undefined') {
                return Validator[rule.method].apply(null, [value, ...rule.args]);
            }
            return Validator[rule.method].apply(null, [value]);
        } else if (typeof rule.method === 'function') {
            if (typeof rule.args !== 'undefined') {
                return rule.method.apply(null, [value, ...rule.args]);
            }
            return rule.method.apply(null, [value]);
        }
    }

    // GETTERS & SETTERS
    set validators(validators) {
        this._validators = validators;
    }

    get validators() {
        return this._validators;
    }

}

export default FormValidator;