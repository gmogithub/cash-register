import React, {Component} from 'react';
import {RightService} from "../../../services/RightService";
import Dialog from '@material-ui/core/Dialog';
import DialogTitle from '@material-ui/core/DialogTitle';
import DialogContent from '@material-ui/core/DialogContent';
import TextField from '@material-ui/core/TextField';
import DialogActions from '@material-ui/core/DialogActions';
import Button from '@material-ui/core/Button';
import FormControl from '@material-ui/core/FormControl';
import SaveIcon from '@material-ui/icons/Save';
import PropTypes from "prop-types";
import {connect} from "react-redux";
import {setRights} from "../../../store/actions/rightAction";

const styles = {
    textfield: {
        paddingBottom: '5px'
    }
};

const rightService = new RightService();

class PureRightDialog extends Component {

    state = {
        right: rightService.newRigth()
    };


    // constructor(props) {
    //     super(props);
    //     console.log(props);
    // }

    componentDidMount() {
    }

    async componentDidUpdate({rightId: rightIdPrev}) {
        const {open, rightId} = this.props;
        let right
        if (rightIdPrev !== rightId) {
            if (open) {
                if (rightId !== 0) {
                    right = await rightService.getRight(rightId);
                } else {
                    right = rightService.newRigth();
                }

                this.setState({
                    right
                });
            }
        }
    }

    handleChange = (name) => (event) => {
        let {right} = this.state;
        right[name] = event.target.value;
        this.setState({
            right: right
        })
    };

    // handleClose = () => {
    //     // this.setProps({open: false});
    //     console.log(this.props)
    //     // this.props.open = false;
    // };

    handleSave = async () => {
        const {right} = this.state;
        // console.log(right)
        let rights = right.id === 0 ? await rightService.save(right) : await rightService.update(right);
        const {dispatchRights} = this.props;
        dispatchRights(rights);
        this.props.closeDialog();
    };

    render() {
        const {closeDialog, open} = this.props;
        const {right} = this.state;
        return <Dialog open={open}>
            <DialogTitle id="form-dialog-title">Ajouter des droit</DialogTitle>
            <DialogContent>
                <FormControl>
                    <TextField id="code" name="code" onChange={this.handleChange("code")} label="Code"
                               style={styles.textfield} value={right.code}/>
                    <TextField id="name" name="name" onChange={this.handleChange("name")} label="Nom"
                               style={styles.textfield} value={right.name}/>
                    <TextField id="description"
                               value={right.description}
                               style={styles.textfield}
                               name="description"
                               onChange={this.handleChange("description")}
                               label="Description"
                               multiline={true}
                               rows={2}
                               rowsMax={4}/>
                    <TextField id="api" name="api" value={right.api} onChange={this.handleChange("api")} label="Api"
                               style={styles.textfield}/>
                </FormControl>
            </DialogContent>
            <DialogActions>
                <Button color="primary" onClick={closeDialog}>
                    Annuler
                </Button>
                <Button onClick={this.handleSave} color="primary">
                    <SaveIcon/>
                    Enregistrer
                </Button>
            </DialogActions>
        </Dialog>;
    }
}

PureRightDialog.propTypes = {
    open: PropTypes.bool,
    closeDialog: PropTypes.func,
    id: PropTypes.number
};

PureRightDialog.defaultProps = {
    open: false,
    id: 0
};

const mapDispatchToProps = dispatch => ({
    dispatchRights: rights => dispatch(setRights(rights))
});

export const RightDialog = connect(null, mapDispatchToProps)(PureRightDialog);
