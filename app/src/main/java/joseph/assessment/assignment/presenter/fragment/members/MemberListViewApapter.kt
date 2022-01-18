package joseph.assessment.assignment.presenter.fragment.members

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import joseph.assessment.assignment.data.member.Member
import joseph.assessment.assignment.databinding.MemberViewitemLayoutBinding
import joseph.assessment.assignment.domain.api.TandemApi

class MemberListViewAdapter : RecyclerView.Adapter<MemberListViewAdapter.MemberItemViewHolder>() {


    private val list: MutableList<Member> = mutableListOf()

    public fun setList(list: MutableList<Member>) {
        this.list.clear()
        this.list.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberItemViewHolder =
        MemberItemViewHolder(
            MemberViewitemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MemberItemViewHolder, position: Int) {
        holder.bind(list[position])
    }


    override fun getItemCount(): Int = list.size


    class MemberItemViewHolder(val binding: MemberViewitemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(member:Member){
                binding.apply {
                  profileName.text = member.firstName
                  newBadge.isVisible = member.referenceCnt == 0
                  refCount.isVisible = member.referenceCnt != 0
                  refCount.text = member.referenceCnt.toString()
                  topicTv.text = member.topic
                  nativesContent.text = member.natives.reduce{acc,next->"$acc, $next"}
                  learnsContent.text = member.learns.reduce{acc,next->"$acc, $next"}

                }
            }

    }

}