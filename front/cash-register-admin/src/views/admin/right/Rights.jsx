import React, {Component} from 'react';
// import {RightService} from '../repositories/RightRepository';
import {RightService} from "../../../services/RightService";
import {GMTable} from "../../../components/gui/GMTable";
import TableCell from '@material-ui/core/TableCell';
import Button from '@material-ui/core/Button';
import AddIcon from '@material-ui/icons/Add';
// import {TestDecorator} from "../../../utils/TestDecorator";
// import Dialog from '@material-ui/core/Dialog';
// import DialogTitle from '@material-ui/core/DialogTitle';
// import DialogContent from '@material-ui/core/DialogContent';
// import TextField from '@material-ui/core/TextField';
// import DialogActions from '@material-ui/core/DialogActions';
import {connect} from "react-redux";
import {setRights} from "../../../store/actions/rightAction";
// // import InputLabel from '@material-ui/core/InputLabel';
// import FormControl from '@material-ui/core/FormControl';
// import SaveIcon from '@material-ui/icons/Save';
import {RightDialog} from "./RightDialog";

// const styles = {
//     textfield: {
//         paddingBottom: '5px'
//     }
// };


const rightService = new RightService();

class PureRights extends Component {

    state = {
        open: false,
        rightId: 0
    };

    async componentDidMount () {
        const rights = await rightService.getRights();
        const {dispatchRights} = this.props;
        dispatchRights(rights);
    }

    componentDidUpdate (prevProps, prevState, snapshot) {
    }

    handleClickOpen = () => {
        this.setState({
            open: true,
            rightId: 0
        });
    };

    handleClose = () => {
        this.setState({open: false});
    };

    selectRight = async (id) => {
        this.setState({
            rightId: parseInt(id, 10),
            open: true
        });

    };

    handleDelete = (id) => async (e) => {
        e.stopPropagation();
        let rights = await rightService.delete(id);
        const {dispatchRights} = this.props;
        dispatchRights(rights);
    };

    getDataRights () {
        let {rights} = this.props;
        let dataNew
        let data = rights.map((right) => {
            dataNew = Object.assign(right);
            dataNew._actions = [{name: 'Supprimer', action: this.handleDelete}];
            return dataNew;
        })
        return data;
    }

    render () {
        let {open, rightId} = this.state;
        let rights = this.getDataRights()
        // let test = TestDecorator.newInstance();

        // let {right} = this.state;
        // let {open} = this.state;
        return (<div>
            <div>
                <Button variant="fab" color="primary" aria-label="Add" onClick={this.handleClickOpen}>
                    <AddIcon/>
                </Button>
            </div>
            <RightDialog open={open} rightId={rightId} closeDialog={this.handleClose}/>
            <GMTable data={rights} onRowSelect={this.selectRight}>
                <TableCell>Code</TableCell>
                <TableCell>Name</TableCell>
                <TableCell>Description</TableCell>
                <TableCell>Api access</TableCell>
                <TableCell>Actions</TableCell>
            </GMTable>
        </div>);
    }
}

const mapDispatchToProps = dispatch => ({
    dispatchRights: rights => dispatch(setRights(rights))
});

const mapStateToProps = state => ({
    rights: state.rightReducer.rights
});

export const Rights = connect(mapStateToProps, mapDispatchToProps)(PureRights);