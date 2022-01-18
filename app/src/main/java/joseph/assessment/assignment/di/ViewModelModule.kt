package joseph.assessment.assignment.di

import joseph.assessment.assignment.presenter.fragment.members.MembersListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MembersListViewModel(get()) }
}