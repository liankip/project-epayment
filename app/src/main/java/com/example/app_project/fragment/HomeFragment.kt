package com.example.app_project.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.app_project.R
import com.synnapps.carouselview.ImageListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_project.activity.SaldoActivity
import com.example.app_project.activity.SlideActivity
import com.example.app_project.activity.WithdrawActivity
import com.example.app_project.adapter.InfoAdapter
import com.example.app_project.adapter.MenuAdapter
import com.example.app_project.databinding.FragmentHomeBinding
import com.example.app_project.model.Info
import com.example.app_project.model.Menu

class HomeFragment : Fragment() {

    private var imagesBanner = arrayOf(
        "https://res.cloudinary.com/funmo-co-id/image/upload/v1624418447/banner/game_wfkbd9.jpg",
        "https://res.cloudinary.com/funmo-co-id/image/upload/v1624418459/banner/BANNER-FUNMO_akudxs.jpg",
        "https://res.cloudinary.com/funmo-co-id/image/upload/v1624418466/banner/csnew_rix68k.jpg",
        "https://res.cloudinary.com/funmo-co-id/image/upload/v1624418473/banner/ppob_k2ypfw.jpg"
    )

    private lateinit var binding: FragmentHomeBinding

    private lateinit var infoAdapter: InfoAdapter
    private val listInfo = LinearLayoutManager(activity)
    private val addInfoList: MutableList<Info> = ArrayList()

    private lateinit var  menuAdapter: MenuAdapter
    private val listMenu = GridLayoutManager(activity, 3)
    private var addMenuList: MutableList<Menu> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtName.text = "Haikal"
        binding.txtSaldo.text = "Rp. 1.000.000"

        binding.btnSaldo.setOnClickListener {
            val i = Intent(activity, SaldoActivity::class.java)
            i.putExtra("title_saldo", "Saldo")
            startActivity(i)
        }

        binding.btnWithdraw.setOnClickListener {
            val i = Intent(activity, WithdrawActivity::class.java)
            i.putExtra("title_withdraw", "Withdraw")
            startActivity(i)
        }

        initBanner()
        initMenu()
        initInfo()
    }

    private fun initBanner() {
        val bannerSlide = binding.carouselView
        bannerSlide.setImageListener(imageListener);
        bannerSlide.pageCount = imagesBanner.size
        bannerSlide.setImageClickListener { position ->
            when (position.toString()) {
                "0" -> {
                    val i = Intent(context, SlideActivity::class.java)
                    i.putExtra("banner_title", "Topup Game Lebih Mudah")
                    i.putExtra("banner_desc", "Topup Game Lebih Mudah")
                    i.putExtra("image_banner", imagesBanner[0])
                    context?.startActivity(i)
                }
                "1" -> {
                    val i = Intent(context, SlideActivity::class.java)
                    i.putExtra("banner_title", "Pembayaran Funmo")
                    i.putExtra("banner_desc", "Topup Game Lebih Mudah")
                    i.putExtra("image_banner", imagesBanner[1])
                    context?.startActivity(i)
                }
                "2" -> {
                    val i = Intent(context, SlideActivity::class.java)
                    i.putExtra("banner_title", "New Customer Service")
                    i.putExtra("banner_desc", "Topup Game Lebih Mudah")
                    i.putExtra("image_banner", imagesBanner[2])
                    context?.startActivity(i)
                }
                "3" -> {
                    val i = Intent(context, SlideActivity::class.java)
                    i.putExtra("banner_title", "Pakai Fun... Lebih haveFun")
                    i.putExtra("banner_desc", "Topup Game Lebih Mudah")
                    i.putExtra("image_banner", imagesBanner[3])
                    context?.startActivity(i)
                }
            }
        }
    }

    private fun initMenu() {
        binding.rvMenu.layoutManager = listMenu
        menuAdapter = MenuAdapter(requireActivity())
        binding.rvMenu.adapter = menuAdapter

        addMenuList.add(Menu("Pulsa","Desc",R.drawable.ic_home))
        addMenuList.add(Menu("Voucher","Desc",R.drawable.ic_home))
        addMenuList.add(Menu("Media","Desc",R.drawable.ic_home))

        menuAdapter.setMenu(addMenuList)
    }

    private fun initInfo() {
        binding.rvInfo.layoutManager = listInfo
        infoAdapter = InfoAdapter(requireActivity())
        binding.rvInfo.adapter = infoAdapter

        addInfoList.add(Info(
            "Layanan deposit bank",
            "Jam Deposit Melalui Bank",
            "Haiiiii... Teruntuk kepada para Mitra, Mohon maaf untuk mekanisme Layanan Deposit Hanya dari pukul 01.00 S/D 22.00 Dikarenakan beberapa Internet Banking tidak Support untuk pembacaan mutasi. Bilamana ada Transfer di atas jam 22.00 Mohon maaf akan kami proses Dihari selanjutnya. Terima Kasih."))

        addInfoList.add(Info(
            "Bisnis berkembang via network",
            "Network Marketing Bisnis",
            "Ajak teman-teman kamu bergabung dan dapatkan Bonus Komisi dari setiap Temanmu bertransaksi. Silahkan Hubungi Upline kamu."))

        addInfoList.add(Info(
            "Produk lengkap dan murah",
            "Harga murah dan transaksi 24Jam NonStop",
            "Cek produk di menu menu aplikasi kita. semua produk ada mulai dari Data,Pulsa dan PPOB. ada produk menarik juga loh. Seperti M-Tix dan TIX-ID"))

        addInfoList.add(Info(
            "Diskon produk PPOB",
            "Diskon untuk pembayaran PPOB",
            "Layanan pembayaran produk PPOB akan mendapatkan fee dan potonga Harga"))

        infoAdapter.setInfo(addInfoList)
    }

    private var imageListener = ImageListener { position, imageView ->
        context?.let { Glide.with(it).load(imagesBanner[position]).into(imageView) };
    }
}