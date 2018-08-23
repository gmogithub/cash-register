import React, {Component} from 'react';
import FormValidator from '../../../utils/FormValidator/FormValidator';

const Form = (WrappedComponent) => {
    class HOC extends Component {

        constructor(props) {
            super(props);
            const validator = new FormValidator();
            this.state = {
                validator,
            };
        }

        onFieldChange(field, event, customValue, validate = true) {
            let value;
            if (customValue !== undefined) {
                value = customValue;
            } else {
                value = event.target.value ? event.target.value : '';
            }
            this.setState({
                [field]: value,
            });
            if (validate) {
                this.props.validator.validateField(field, value);
            }
        }

        //DEPRECATED, WILL BE REMOVED
        baseStyleField(field) {
            return field === '' ? 'empty' : 'notEmpty';
        }

        commonStyle(field) {
            return field === '' ? 'empty' : 'notEmpty';
        }

        render() {
            return <WrappedComponent
                validator={this.state.validator}
                baseStyleField={this.baseStyleField}
                commonStyle={this.commonStyle}
                onFieldChange={this.onFieldChange}
                {...this.props}
            />;
        }
    }

    return HOC;
};

export default Form;