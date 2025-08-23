/* ---------------------  AUTH / UI --------------------- */
document.addEventListener("DOMContentLoaded", function () {
  ['forgotModal', 'activateModal'].forEach(id => {
    const modal = document.getElementById(id);
    if (modal) new bootstrap.Modal(modal);
  });

  const registerForm = document.getElementById("registerForm");
  const registerModalBody = document.getElementById("registerModalBody");
  const loginForm = document.getElementById("loginForm");
  const loginSection = document.getElementById("loginSection");
  const userSection = document.getElementById("userSection");
  const userNameSpan = document.getElementById("userName");
  const logoutIcon = document.getElementById("logoutIcon");
  const topLinksSection = document.getElementById("topLinksSection");
  const railVideosSection = document.getElementById("railVideosSection");

  if (registerForm) {
    registerForm.addEventListener("submit", function (event) {
      event.preventDefault();
      const formData = Object.fromEntries(new FormData(registerForm));

      fetch("http://localhost:8082/api/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
      })
        .then(response => {
          if (!response.ok) {
            return response.json().then(data => { throw new Error(data.message || "Registration failed."); });
          }
          return response.json();
        })
        .then(() => {
          registerModalBody.innerHTML = `<div class="alert alert-success text-center"><strong>User is created!</strong> An email has been sent to <strong>${formData.email}</strong> with activation instructions.</div>`;
        })
        .catch(error => {
          console.error("Registration error:", error);
          alert(error.message || "Registration failed. Please try again.");
        });
    });
  }

  function updateUI() {
    const token = localStorage.getItem("token");
    const userName = localStorage.getItem("userName");

    if (token && userName) {
      loginSection.classList.add("d-none");
      userSection.classList.remove("d-none");
      userNameSpan.textContent = userName;
      topLinksSection.classList.add("d-none");
      if (railVideosSection) railVideosSection.classList.remove("d-none");
    } else {
      loginSection.classList.remove("d-none");
      userSection.classList.add("d-none");
      userNameSpan.textContent = "";
      topLinksSection.classList.remove("d-none");
      if (railVideosSection) railVideosSection.classList.add("d-none");
    }
  }

  if (loginForm) {
    loginForm.addEventListener("submit", function (event) {
      event.preventDefault();
      const formData = new FormData(loginForm);
      const email = formData.get("email");
      const password = formData.get("password");

      fetch("http://localhost:8080/auth/authenticate", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      })
        .then(response => {
          if (!response.ok) {
            throw new Error("Invalid login credentials");
          }
          return response.json();
        })
        .then(data => {
          localStorage.setItem("token", data.access_token);
          localStorage.setItem("refresh_token", data.refresh_token);
          localStorage.setItem("userName", email);
          localStorage.setItem("email", email);
          localStorage.setItem("userId", email);
          localStorage.setItem("author", email);
          localStorage.setItem("postId", "");
          localStorage.setItem("audioUrls", "");
          localStorage.setItem("imageUrls", "");
          localStorage.setItem("videoUrls", "");
          localStorage.setItem("documents", "");
          localStorage.setItem("description", "");
          localStorage.setItem("isevent", false);
          localStorage.setItem("ismemory", false);
          localStorage.setItem("ispublic", false);

          updateUI();
          window.location.href = "/dashboard";
        })
        .catch(error => {
          console.error("Login failed:", error);
          alert("Login failed. Please check your credentials.");
        });
    });
  }

  if (logoutIcon) {
    logoutIcon.addEventListener("click", function () {
      cleanSession();
      updateUI();
      window.location.href = "/";
    });
  }

  updateUI();
});

window.showBazaar = function () {
  document.getElementById("iframe-container").classList.remove("d-none");
  document.getElementById("app-container").classList.add("d-none");
  document.getElementById("myContents-container").classList.add("d-none");
};
window.showApp = function () {
  document.getElementById("iframe-container").classList.add("d-none");
  document.getElementById("app-container").classList.remove("d-none");
  document.getElementById("myContents-container").classList.add("d-none");
};
window.showMyContent = function () {
  document.getElementById("myContents-container").classList.remove("d-none");
  document.getElementById("iframe-container").classList.add("d-none");
  document.getElementById("app-container").classList.add("d-none");
};

/* ---------------------  UPLOAD MODAL --------------------- */
document.addEventListener("DOMContentLoaded", function () {
  const dropZone = document.getElementById("dropZone");
  const fileInput = document.getElementById("fileElem");
  const fileNameDisplay = document.getElementById("fileNameDisplay");

  const MAX_SIZE_MB = 25000;

  ['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
    dropZone.addEventListener(eventName, e => {
      e.preventDefault();
      e.stopPropagation();
    }, false);
  });

  dropZone.addEventListener("dragover", () => {
    dropZone.classList.add("bg-light");
  });

  dropZone.addEventListener("drop", (e) => {
    e.preventDefault();
    dropZone.classList.remove("bg-light");
    const file = e.dataTransfer.files[0];
    if (file) handleFileSelect(file);
  });

  fileInput.addEventListener("change", (e) => {
    const file = e.target.files[0];
    if (file) handleFileSelect(file);
  });

  function handleFileSelect(file) {
    const maxBytes = MAX_SIZE_MB * 1024 * 1024;
    if (file.size > maxBytes) {
      alert("File exceeds the 1000MB size limit.");
      fileInput.value = "";
      fileNameDisplay.textContent = "";
      return;
    }
    const dt = new DataTransfer();
    dt.items.add(file);
    fileInput.files = dt.files;
    fileNameDisplay.textContent = file.name;

    uploadFile(file);
  }
});

/* Upload logic */
function uploadFile(file) {
  const formData = new FormData();
  formData.append("file", file);
  formData.append("userId", localStorage.getItem("userId"));

  formData.append("ismemory", document.getElementById("memorySwitch").checked);
  localStorage.setItem("ismemory", document.getElementById("memorySwitch").checked);

  formData.append("isslice", document.getElementById("sliceSwitch").checked);
  localStorage.setItem("isslice", document.getElementById("sliceSwitch").checked);

  formData.append("ispublic", document.getElementById("publicSwitch").checked);
  localStorage.setItem("ispublic", document.getElementById("publicSwitch").checked);

  formData.append("isevent", document.getElementById("eventSwitch").checked);
  localStorage.setItem("isevent", document.getElementById("eventSwitch").checked);

  formData.append("author", localStorage.getItem("userId"));

  formData.append("description", sanitizeText(document.getElementById('description').value), 100);
  localStorage.setItem("description", sanitizeText(document.getElementById("description").value), 100);

  if (!localStorage.getItem("postId")) {
    formData.append("postId", "");
  } else {
    formData.append("postId", localStorage.getItem("postId").trim().replace(/,$/, ''));
  }

  fetch("http://localhost:8082/api/upload", {
    method: "POST",
    body: formData
  })
    .then(res => res.json())
    .then(data => {
      localStorage.setItem("postId", data.id);
      localStorage.setItem("audioUrls", data.audioUrls);
      localStorage.setItem("documentUrls", data.documentUrls);
      localStorage.setItem("imageUrls", data.imageUrls);
      localStorage.setItem("videoUrls", data.videoUrls);
      previewPost(data);
    })
    .catch(err => {
      console.error("Upload error:", err);
    });
}

window.sendThePost = function () {
  const formData = new FormData();
  formData.append("userId", localStorage.getItem("userId"));
  formData.append("ismemory", document.getElementById("memorySwitch").checked);
  localStorage.setItem("ismemory", document.getElementById("memorySwitch").checked);

  localStorage.setItem("isslice", document.getElementById("sliceSwitch").checked);
  formData.append("isslice", document.getElementById("sliceSwitch").checked);

  formData.append("ispublic", document.getElementById("publicSwitch").checked);
  localStorage.setItem("ispublic", document.getElementById("publicSwitch").checked);

  formData.append("isevent", document.getElementById("eventSwitch").checked);
  localStorage.setItem("isevent", document.getElementById("eventSwitch").checked);

  formData.append("author", document.getElementById("author"));
  formData.append("description", sanitizeText(document.getElementById('description').value), 100);
  localStorage.setItem("description", sanitizeText(document.getElementById("description").value), 100);

  if (!localStorage.getItem("postId")) {
    formData.append("postId", "");
  } else {
    formData.append("postId", localStorage.getItem("postId").trim().replace(/,$/, ''));
  }

  fetch("http://localhost:8082/api/submit", {
    method: "POST",
    body: formData
  });
};

function handleFilesPost(files) {
  if (files.length > 0) {
    uploadFile(files[0]);
  }
}

function previewPost(post) {
  if (!post) return;
  $("#attachedVideos").empty();
  $("#attachedImages").empty();
  $("#attachedAudios").empty();
  $("#attachedFiles").empty();
  const getFullPath = (url) => "http://localhost:3000/" + url.split("webdata/")[1];

  if (post.videoUrls?.length > 0) {
    post.videoUrls.forEach((url, index) => {
      const file = getFullPath(url);
      const size = index === 0 ? 'width="450" height="200"' : 'width="150" height="100"';
      const html = `<video src="${file}" controls ${size} style="margin:5px;"></video>`;
      $("#attachedVideos").append(html);
    });
  }

  if (post.imageUrls?.length > 0) {
    post.imageUrls.forEach((url, index) => {
      const file = getFullPath(url);
      const size = index === 0 ? 'width="300"' : 'width="150"';
      const html = `<img src="${file}" ${size} style="margin:5px;" />`;
      $("#attachedImages").append(html);
    });
  }

  if (post.audioUrls?.length > 0) {
    post.audioUrls.forEach((url, index) => {
      const file = getFullPath(url);
      const html = `<audio src="${file}" controls style="display:block; margin:5px; ${index === 0 ? 'width:500px;' : 'width:200px;'}"></audio>`;
      $("#attachedAudios").append(html);
    });
  }

  if (post.documents?.length > 0) {
    post.documents.forEach((doc) => {
      const url = doc.url;
      const file = getFullPath(url);
      const filename = url.split("webdata/tmp/")[1];
      let img = "/resources/images/file.png";
      if (doc.type === "DOC" || doc.type === "DOCX") img = "/resources/images/word.png";
      else if (doc.type === "PPTX" || doc.type === "PPT") img = "/resources/images/pptx.png";
      else if (doc.type === "PDF") img = "/resources/images/pdf.png";
      else if (doc.type === "XLS" || doc.type === "XLSX") img = "/resources/images/xlsx.png";

      const html = `<div><a href="${file}" target="_blank"><img src="${img}" width="50px">${filename}</a></div>`;
      $("#attachedFiles").append(html);
    });
  }
}

function cleanSession() {
  localStorage.removeItem("token");
  localStorage.removeItem("refresh_token");
  localStorage.removeItem("userName");
  localStorage.removeItem("postId");
  localStorage.removeItem("audioUrls");
  localStorage.removeItem("documentUrls");
  localStorage.removeItem("imageUrls");
  localStorage.removeItem("videoUrls");
  localStorage.removeItem("author");
  localStorage.removeItem("description");
  localStorage.removeItem("documents");
  localStorage.removeItem("email");
  localStorage.removeItem("isevent");
  localStorage.removeItem("ismemory");
  localStorage.removeItem("ispublic");
  localStorage.removeItem("userId");
  localStorage.removeItem("author");
  cleanUploadModal();
}

function cleanHideUploadModal() {
  localStorage.removeItem("postId");
  localStorage.removeItem("audioUrls");
  localStorage.removeItem("documentUrls");
  localStorage.removeItem("imageUrls");
  localStorage.removeItem("videoUrls");
  localStorage.removeItem("description");
  localStorage.removeItem("documents");
  localStorage.removeItem("email");
  localStorage.removeItem("isevent");
  localStorage.removeItem("ismemory");
  localStorage.removeItem("ispublic");
  cleanUploadModal();
}

function cleanUploadModal() {
  document.getElementById("description").value = "";
  document.getElementById("publicSwitch").checked = false;
  document.getElementById("eventSwitch").checked = false;
  document.getElementById("memorySwitch").checked = false;
  document.getElementById("sliceSwitch").checked = false;

  document.getElementById("attachedVideos").innerHTML = "";
  document.getElementById("attachedImages").innerHTML = "";
  document.getElementById("attachedAudios").innerHTML = "";
  document.getElementById("attachedFiles").innerHTML = "";
}

/* ---------------------  GRAPHQL PAGINATION --------------------- */
let currentPage = 0;
const pageSize = 10;
let hasNext = true;
let isLoading = false;
const seen = new Set();

const POSTS_QUERY = `
  query($page: Int!, $size: Int!) {
    getAllPostsPaged(page: $page, size: $size) {
      items {
        id
        description
        author
        hlsVideoUrls
        videoImagePath
        createdAt
        slice
      }
      pageInfo {
        page
        size
        hasNext
        hasPrev
      }
    }
  }
`;

async function fetchAndRenderPosts(page = 0) {
  if (isLoading || (!hasNext && page !== 0)) return;
  isLoading = true;

  try {
    const res = await fetch("http://localhost:8082/graphql", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        // If secured, uncomment:
        "Authorization": `Bearer ${localStorage.getItem("token") || ""}`
      },
      body: JSON.stringify({
        query: POSTS_QUERY,
        variables: { page, size: pageSize }
      }),
    });

    const json = await res.json();
    if (json.errors) {
      console.error("GraphQL errors:", json.errors);
      return;
    }

    const data = json?.data?.getAllPostsPaged;
    if (!data) {
      console.error("Bad GraphQL shape:", json);
      return;
    }

    const { items, pageInfo } = data;
    hasNext = pageInfo.hasNext;
    currentPage = pageInfo.page; // trust backend

    const visibleItems = (items || []).filter(post => !post.slice);

    renderPosts(visibleItems);
  } catch (err) {
    console.error("GraphQL fetch error:", err);
  } finally {
    isLoading = false;
  }
}

function renderPosts(posts) {
  const container = document.getElementById("mainPageVideos");
  posts.forEach(post => {
    if (!post || seen.has(post.id)) return;
    seen.add(post.id);

    if (!post.hlsVideoUrls || post.hlsVideoUrls.length === 0) return;

    const hlsUrl = "http://localhost:3000/" + post.hlsVideoUrls[0].split("webdata/")[1];
    const videoImagePath = "http://localhost:3000/" + post.videoImagePath.split("webdata/")[1];
    const videoId = `video-${post.id}`;
    const thumbnailId = `thumbnailId-${post.id}`;
    const logo = `logo-${post.id}`;
    const cardHtml = `
      <div class="col-12 col-md-6 col-xl-4 post-card" data-id="${post.id}">
        <div class="card h-100">
          <div class="card-body position-relative">
            <!-- Switch between thumbnail/video as needed -->
            <video id="${videoId}" controls class="video-max-200"></video>
            <!-- <img id="${thumbnailId}" src="${videoImagePath}" class="video-max-200"> -->

            <table>
              <tr>
                <td><span id="${logo}" class="logo-span"></span></td>
                <td>
                  <p class="card-text">${sanitizeText(post.description, 80) || ""}</p>
                </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    `;

    container.insertAdjacentHTML("beforeend", cardHtml);
    renderCircleInSpan(logo);

    const video = document.getElementById(videoId);
    if (Hls.isSupported()) {
      const hls = new Hls();
      hls.loadSource(hlsUrl);
      hls.attachMedia(video);
      hls.on(Hls.Events.MEDIA_ATTACHED, () => {
        video.muted = true;
      });
      hls.on(Hls.Events.ERROR, function (event, data) {
        console.error("HLS.js error:", data);
      });
    } else if (video.canPlayType('application/vnd.apple.mpegurl')) {
      video.src = hlsUrl;
    }
  });
}

/* IntersectionObserver for infinite scroll */
document.addEventListener("DOMContentLoaded", () => {
  const bottomSentinel = document.getElementById("bottom-sentinel");
  const observer = new IntersectionObserver(entries => {
    for (const entry of entries) {
      if (entry.isIntersecting) {
        if (hasNext) {
          fetchAndRenderPosts(currentPage + 1);
        } else {
          observer.unobserve(bottomSentinel);
          // Optionally show "You're all caught up"
        }
      }
    }
  }, { rootMargin: "1000px" });

  observer.observe(bottomSentinel);

  // Initial load
  fetchAndRenderPosts(0);
});

function sanitizeText(input, maxLength = 80) {
  // 0. Replace underscores and hyphens with spaces
  let clean = input.replace(/[_-]/g, " ");

  // 1. Remove special characters except letters, numbers, and spaces
  clean = clean.replace(/[^\w\s]|_/g, "");

  // 2. Replace multiple spaces with a single space
  clean = clean.replace(/\s+/g, " ");

  // 3. Escape HTML/JS tags to prevent injection
  clean = clean.replace(/[<>&"'`]/g, function (char) {
    const map = {
      '<': '&lt;',
      '>': '&gt;',
      '&': '&amp;',
      '"': '&quot;',
      "'": '&#x27;',
      '`': '&#x60;'
    };
    return map[char];
  });

  // 4. Trim and slice to maxLength
  return clean.trim().slice(0, maxLength);
}

function getRandomColor() {
  const letters = '0123456789ABCDEF';
  let color = '#';
  for (let i = 0; i < 6; i++)
    color += letters[Math.floor(Math.random() * 16)];
  return color;
}

function renderCircleInSpan(spanId) {
  const span = document.getElementById(spanId);
  if (!span) return;

  // Clear any previous content
  span.innerHTML = '';

  // 70% of previous 100x100
  const size = 70;         // canvas width/height
  const radius = 28;       // ~40 * 0.7
  const center = size / 2; // 35

  const canvas = document.createElement('canvas');
  canvas.width = size;
  canvas.height = size;
  span.appendChild(canvas);

  const ctx = canvas.getContext('2d');

  // Circle color: random
  const bgColor = '#' + Math.floor(Math.random() * 16777215).toString(16).padStart(6, '0');
  ctx.fillStyle = bgColor;
  ctx.beginPath();
  ctx.arc(center, center, radius, 0, Math.PI * 2);
  ctx.fill();

  // Text: fixed black, 20% bigger than before (12px → 14px)
  ctx.fillStyle = '#000000';
  ctx.font = 'bold 14px Arial';
  ctx.textAlign = 'center';
  ctx.textBaseline = 'middle';
  ctx.fillText('H', center, center);
}
