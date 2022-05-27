package com.example.wordappnav

import android.os.Bundle
import android.view.*
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordappnav.databinding.FragmentLetterkBinding
import com.example.wordappnav.databinding.FragmentWordBinding

class WordFragment : Fragment() {
    private var _binding: FragmentWordBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        _binding = FragmentWordBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.recyclerView.adapter = RecyclerViewWordAdapter(requireContext(),
            arguments?.getString("letter").toString().first() ?:' ')
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_change_menu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.layoutChanger) {
            if (item.title.equals("Grid")){
                item.icon = getDrawable(requireContext(),R.drawable.ic_linear_vertical)
                item.title= "Vertical"
                changeLayoutToGrid()
            }else{
                item.icon = getDrawable(requireContext(),R.drawable.ic_grid_view)
                item.title = "Grid"
                changeLayoutToVertical()
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    private fun changeLayoutToGrid() {
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
    }

    private fun changeLayoutToVertical() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }
}