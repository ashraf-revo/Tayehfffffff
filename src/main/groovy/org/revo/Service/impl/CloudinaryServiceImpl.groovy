package org.revo.Service.impl

import com.cloudinary.Cloudinary
import com.cloudinary.utils.ObjectUtils
import org.revo.Service.CloudinaryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by ashraf on 3/27/2016.
 */
@Service
class CloudinaryServiceImpl implements CloudinaryService{
    @Autowired
    Cloudinary cloudinary

    @Override
    String uplode(String file) {
        Map map = cloudinary.uploader().uploadLarge(file.decodeBase64(), ObjectUtils.emptyMap());
        map.get("secure_url") as String
    }
}
